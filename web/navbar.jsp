<%@ page import="moduls.Admin" %>


<div class="mb-3">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/"><%=siteName%></a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                    <%

                    if (session.getAttribute("userType")!=null && session.getAttribute("userType") instanceof Admin){
                    %>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="/add_student">Add Students</a>
                        </li>
                </ul>
                    <%
                        }
                    else {

                        }
                    %>

            </div>
        </div>
    </nav>
</div>
