package cn.bdqn.app.web.admin.exception;

/**
 * @author Mr.Bug
 * @version 1.0
 * @date 2019/3/10 21:18
 * @since 1.8
 */
public class DivException extends RuntimeException {
    /**
     * 无参构造方法
     */
    public DivException() {
        super();
    }

    /**
     * 构造方法
     *
     * @param message 异常详细信息
     */
    public DivException(String message) {
        super(message);
    }

    /**
     * 构造方法
     *
     * @param message 异常详细信息
     * @param cause   异常原因
     */
    public DivException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造方法
     *
     * @param cause 异常原因
     */
    public DivException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造方法
     *
     * @param message            异常详细信息
     * @param cause              异常原因
     * @param enableSuppression  抑制异常传播
     * @param writableStackTrace 可写的堆栈信息
     */
    public DivException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
