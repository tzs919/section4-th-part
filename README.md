# section4-th-part
## Web应用程序（MVC、控制器、Thymeleaf视图）
## 文件上传，multipart
## 将异常映射为http状态码
`@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {
`
## 将异常处理成错误页面
`@ExceptionHandler(DuplicateSpittleException.class)
public String handleNotFound() {
return "error/duplicate";
}`
## 为控制器添加通知
`@ControllerAdvice
public class AppWideExceptionHandler {

@ExceptionHandler(DuplicateSpittleException.class)
public String handleNotFound() {
return "error/duplicate";
}

}`
## 跨重定向请求传递数据
