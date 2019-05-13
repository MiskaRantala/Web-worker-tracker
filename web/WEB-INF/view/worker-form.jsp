<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Add worker</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-worker-style.css">
    </head>
    <body>

    <div id="wrapper">
        <div id="header">
            <h2>WRM - Worker Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Add worker</h3>

        <form:form action="saveWorker" modelAttribute="worker" METHOD="POST">

            <table>
                <tbody>
                    <tr>
                        <td><label>First name: </label></td>
                        <td><form:input path="firstName" /></td>
                    </tr>

                    <tr>
                        <td><label>Last name: </label></td>
                        <td><form:input path="lastName" /></td>
                    </tr>

                    <tr>
                        <td><label>Email: </label></td>
                        <td><form:input path="email" /></td>
                    </tr>

                    <tr>
                        <td><label>Submit!</label></td>
                        <td><input type="submit" value="Save" class="save" /></td>
                    </tr>
                </tbody>
            </table>

        </form:form>

        <div stule="clear; both;">

            <p>
                <a href="${pageContext.request.contextPath}/worker/list">Back to List</a>
            </p>

        </div>

    </div>

    </body>
</html>