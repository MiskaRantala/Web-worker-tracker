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
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our customers -->
                    <c:forEach var="tempWorker" items="${workers}">

                        <!-- construct and "update" link with worker id -->
                        <c:url var="updateLink" value="/worker/showFormForUpdate">
                            <c:param name="workerId" value="${tempWorker.id}" />
                        </c:url>

                        <!-- construct and "delete" link with worker id -->
                        <c:url var="deleteLink" value="/worker/delete">
                            <c:param name="workerId" value="${tempWorker.id}" />
                        </c:url>

                        <tr>
                            <td> ${tempWorker.firstName} </td>
                            <td> ${tempWorker.lastName} </td>
                            <td> ${tempWorker.email} </td>

                            <td>
                                <!-- display the update link -->
                                <a href="${updateLink}">Update</a>
                                |
                                <!-- display the delete link -->
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Are you sure you want to delete this worker?'))) return false">Delete</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>

        </div>

    </body>

</html>