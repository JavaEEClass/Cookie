<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    public Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
%>
<%
    String fontsize = "3";
    if (getCookie(request, "titleFontSize") != null) {
        fontsize = getCookie(request, "titleFontSize").getValue();
    }
%>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <font size="<%=fontsize%>">Title</font>
</body>
</html>
