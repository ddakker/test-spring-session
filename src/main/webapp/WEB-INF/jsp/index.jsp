<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1> Session Test </h1>

<h2> 값 </h2>
<div>
    sessionMap : ${ sessionMap }
</div>

<h3> 등록 </h3>
<div>
    <form action="set">
        <input type="text" name="key" value="" />
        <input type="text" name="value" value="" />
        <input type="submit" value="send" />
    </form>
</div>

<h3> 로그아웃 </h3>
<a href="invalidate">Invalidate</a>

