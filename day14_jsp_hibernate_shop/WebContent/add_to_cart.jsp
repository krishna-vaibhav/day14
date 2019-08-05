<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:setProperty property="*" name="shop" />
<c:redirect url="${sessionScope.shop.populateCart()}.jsp" />