# learning_spring_2
### Spring Boot를 이용한 RESTful Web Services 개발

<br/>

## API
* 사용자 관리 API
    * 전체 사용자 목록 조회: GET HTTP Method, http://localhost:8088/users
    * 개별 사용자 조회: GET HTTP Method, http://localhost:8088/users/{id}
    * 사용자 삭제: DELETE HTTP Method, http://localhost:8088/users/{id}
    * 사용자 정보 수정: PUT HTTP Method, http://localhost:8088/users/{id}
    * 사용자 정보 등록: POST HTTP Method, http://localhost:8088/users

* 게시물 관리 API
    * 전체 게시물 목록 조회: GET HTTP Method, http://localhost:8088/users/{id}/posts
    * 게시물 추가: POST HTTP Method, http://localhost:8088/users/{id}/posts
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

### Validation API
* 데이터 validation을 위한 로직을 도메인 모델 자체에 묶어 표현
* Annotation 사용 `@Valid`
  * ex) `@Size`, `@Past`, `@NotEmpty`, ...
  
### Internationalization
#### MessageSource
* 국제화를 제공하는 인터페이스
* 메세지 설정 파일(.properties)을 모아놓고 각 국가마다 로컬라이징하여 각 지역에 맞춘 메세지 제공
#### LocaleResolver
* SessionLocaleResolver : 세션 이용해서 locale 구함
* CookieLocaleResolver : 쿠키 이용해서 locale 구함


### Filtering
* 도메인 클래스 자체
  * `@JsonIgnoreProperties` : 무시할 속성 목록 표시
  * `@JsonIgnore` : 필드 레벨에서 무시할 속성 표시
* Jackson JsonFilter
  * `@JsonFilter` : Filter ID를 문자열로 지정, `FilterProvider`와 해당 ID를 처리하는 필터 제공해야함
  * `@SimpleBeanPropertyFilter.filterOutAllExcept` : 지정된 필드들만 JSON 변환, 알 수 없는 필드는 무시
  
### Version 관리
* URI, Request parameter, header, mime type
  * `BeanUtils.copyProperties(source, target, String ... ignoreProperties);`
    * source : 원본 객체
    * target : 복사 대상 객체
    * ignoreProperties : 복사를 원하지 않는 프로퍼티
  
### HATEOAS
* Hypermedia As the Engine Of Application State
* 현재 리소스와 연관된(호출 가능한) 자원 상태 정보를 제공

### Swagger
* API들이 가지고 있는 스펙을 명세, 관리
* `localhost:8088/v2/api-docs`
* `localhost:8088/swagger-ui.html`

### Actuator
* 어플리케이션의 상태를 종합적으로 정리하여 제공

### HAL Browser
* Response 메세지에 부가 정보들을 담아 함께 제공

### JPA
* Java Persistence API
* 자바 ORM 기술에 대한 API 표준 명세
* 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스
* EntityManager를 통해 CRUD 처리

#### Hibernate
* JPA의 구현체, 인터페이스를 직접 구현한 라이브러리
* 생산성, 유지보수, 비종속성

#### Spring Data JPA
* Spring Module
* JPA를 추상화한 Repository 인터페이스 제공 
