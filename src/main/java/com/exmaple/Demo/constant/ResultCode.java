package com.exmaple.Demo.constant;

public enum ResultCode {
    /* 成功状态码 */

/*个人使用*/
SUCCESS(0, "成功"),
    ERROR(1, "失败"),
PARAM_TO_MANY(10005, "请求参数过大"),
    TOKEN_LOSE(10006,"token失效"),
    USER_HAS_EXISTED(20005, "用户名已存在"),
    FOOD_HAS_EXISTED(20006, "食品名已存在"),
    SHOP_HAS_EXISTED(20007, "商店名已存在"),
    ROLE_HAS_EXISTED(20008, "角色名已存在"),
    AUTO_HAS_EXISTED(20009, "权限名已存在"),
    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    USER_FORBIDDEN(10007, "该用户已被禁用"),
    USER_NOT_REGISTER(10008, "账号或密码错误"),
    USER_DELETE_SUCCESS(10009, "删除成功"),
    USER_DELETE_ERROR(10010, "删除失败"),
    EDIT_SUCCESS(10011, "修改成功"),
    EDIT_ERROR(10012, "修改失败"),
    NO_P_LABEL(10013, "没有找到父级标签"),
    TAGNAME_ISEXIT(10014, "标签名已经存在"),

    MEIYOUGAIQUANXIAN(10015, "您没有该权限！！！"),
    TO_LOGIN(10016, "您尚未登录，将跳转至登录界面！！！"),
    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_Register_ERROR(20006, "用户注册错误"),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    RESULE_DATA_NONE(50001, "位置已被占领，请刷新后重新挑选"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限"),

    /* 文件上传 */
    UPLOAD_ERROR(80001, "上传失败"),

    SESSION_TIME_OUT(90001, "Session超时");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
