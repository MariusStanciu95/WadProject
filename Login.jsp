
<%@include file="Header.jsp" %>
    <div class="login-form">
        <form method="post" action="loginController" id="form-submit">
            <h3>Login form</h3>
            <br>
            <label for="username">Username</label>
                <input type="text" name="username" id="username">
                <span class="error" style="color:red; display:none;">Username should not pe empty</span>
            <br>
            <label for="password">Password</label>
                <input type="password" name="password" id="password">
                <span class="error" style="color:red; display:none;">Password should not pe empty</span>
            <br>
            <input type="submit" value="Submit" name="send" class="btn btn-default btn-sm">
            <input type="reset" value="Reset" name="clear" class="btn btn-default btn-sm">
            <span id="main-error" style="font-weight:700; color:red; display:none">Check all the errors</span>
        </form>
    </div>

<c:if test="${not empty error}">
    ${error}
</c:if>
               

<%@include file="Footer.jsp" %>
