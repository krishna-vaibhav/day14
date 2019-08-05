<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="shop" class="beans.BookShopBean" scope="session" />
<jsp:setProperty property="*" name="shop" />
<%--invoke B.L method of JB --%>
<%--response.sendRedirect(response.encodeRedirectURL(session.getAttribute("shop").validateCustomer().concat(".jsp")); --%>
<c:redirect url="${sessionScope.shop.validateCustomer()}.jsp" />






