package hello.jdbc.exception.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.sql.SQLException;

public class UnCheckedAppTest {

    @Test
    void unchecked(){
        Controller controller = new Controller();
        Assertions.assertThatThrownBy(()-> controller.request())
                .isInstanceOf(RuntimeSQLException.class);
    }

    static class Controller{
        Service service = new Service();
        public void request() {
            service.logic();
        }
    }

    static class Service{
        Repository repository = new Repository();
        NetWorkClient netWorkClient = new NetWorkClient();

        public void logic() {
            repository.call();
            netWorkClient.call();
        }
    }

    static class NetWorkClient{
        public void call() {
            throw new RuntimeConnectException("ex");
        }
    }

    static class Repository{
        public void call(){
            try{
                runSQL();
            } catch (SQLException e){
                throw new RuntimeSQLException(e);
            }
        }

        public void runSQL () throws SQLException {
            throw new SQLException("ex");
        }
    }

    static class RuntimeConnectException extends RuntimeException{
        public RuntimeConnectException(String message) {
            super(message);
        }
    }

    static class RuntimeSQLException extends RuntimeException{
        public RuntimeSQLException(Throwable cause) {
            super(cause);
        }
    }

}
