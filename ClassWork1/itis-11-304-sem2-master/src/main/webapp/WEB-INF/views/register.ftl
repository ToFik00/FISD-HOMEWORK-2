<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Registration</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>Register</h2>
<form action="<@spring.url '/register'/>" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <#if RequestParameters.error??>
        <div style="color: red">
            <p>Username already exists!</p>
        </div>
    </#if>

    <div>
        <label>Username:
            <@spring.formInput "user.username" "" "text"/>
        </label>
    </div>

    <div>
        <label>Password:
            <@spring.formPasswordInput "user.password" ""/>
        </label>
    </div>

    <button type="submit">Register</button>
</form>
</body>
</html>