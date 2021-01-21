# learning_spring_2
### Spring Boot를 이용한 RESTful Web Services 개발

<br/>

## API
* 사용자 관리 API
    * 전체 사용자 목록 조회: GET HTTP Method, http://localhost:8088/users
    * 개별 사용자 조회: GET HTTP Method, http://localhost:8088/users/{id}
    * 사용자 삭제: DELETE HTTP Method, http://localhost:8088/users/{id}
    * 사용자 정보 수정: PUT HTTP Method, http://localhost:8088/users/{id}

* 게시물 관리 API
    * 전체 게시물 목록 조회: GET HTTP Method, http://localhost:8088/users/{id}/posts
    * 게시물 삭제: DELETE HTTP Method, http://localhost:8088/users/{id}/posts/{post_id}
  
<br/>

## study
### DispatcherServlet
* 클라이언트의 모든 요청을 한곳으로 받아서 처리
* 요청에 맞는 Handler로 요청을 전달
* Handler의 실행 결과를 Http Response 형태로 만들어서 반환
* -> 사용자의 요청은 DispatcherServlet에서 시작되고 DispatcherServlet으로 끝남

### RestController
* `@RestController` (Spring4부터 지원)
* `@Controller` + `@ResponseBody`
* view를 갖지 않는 REST Data(JSON/XML) 반환

### Exception Handling
* `@ResponseStatus` : response code와 error reason 설정
* `@ControllerAdvice` : 모든 컨트롤러가 실행될 때 해당 어노테이션을 가지고있는 빈이 사전 실행됨