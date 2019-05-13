<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <head>
        <title>List of workers</title>

        <!-- reference our style sheet -->

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

    </head>

    <body>

        <div id="wrapper">
            <div id="header">
                <h2>WRM - Worker Relationship Manager</h2>
            </div>
        </div>

        <div id="container">

            <div id="content">

                <!-- add a button here: Save Worker -->
                <input type="button" value="Add worker" onclick="window.location.href='showFormForAdd'; return false;"
                       class="add-button" />

                <!-- html table goes here -->
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="tempWorker" items="${workers}">

                        <tr>
                            <td> ${tempWorker.firstName} </td>
                            <td> ${tempWorker.lastName} </td>
                            <td> ${tempWorker.email} </td>
                        </tr>

                    </c:forEach>

                </table>

            </div>

        </div>

    </body>

</html>