<%@page import="HelperClasses.Member"%>
<%@page import="HelperClasses.Furniture"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="checkCountry.jsp" />
<%
    Boolean isMemberLoggedIn = false;
    String memberEmail = (String) (session.getAttribute("memberEmail"));
    if (memberEmail == null) {
        isMemberLoggedIn = false;
    } else {
        isMemberLoggedIn = true;
    }
    String category = URLDecoder.decode(request.getParameter("cat"));
    if (category == null) {
        pageContext.forward("/ECommerce_SelectCountry");
    }
%>
<html> <!--<![endif]-->
    <jsp:include page="header.html" />
    <body>
        <%
            List<Furniture> furnitures = (List<Furniture>) (session.getAttribute("furnitures"));
            System.out.println("furniture size:" + furnitures.size());
        %>
        <div class="body">
            <jsp:include page="menu2.jsp" />
            <div class="body">
                <div role="main" class="main">
                    <section class="page-top">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <h2>Furnitures</h2>
                                </div>
                            </div>
                        </div>
                    </section>
                    <div class="container">

                        <div class="row">
                            <div class="col-md-6">
                                <h2 class="shorter"><strong><%=category%></strong></h2>
                            </div>
                        </div>
                        <div class="row">
                            <ul class="products product-thumb-info-list" data-plugin-masonry>
                                <%
                                    try {
                                        /**
                                         * *insert code here**
                                         */
                                %>
                                <li class="col-md-3 col-sm-6 col-xs-12 product">
                                    <span class="product-thumb-info">
                                        <span class="product-thumb-info-image">
                                            <img alt="" class="img-responsive" src="../../..<%=furnitures.get(0).getImageUrl()%>">
                                        </span>

                                        <span class="product-thumb-info-content">
                                            <h4><%=furnitures.get(0).getName()%></h4>
                                            <span class="product-thumb-info-act-left"><em>Height: <%=furnitures.get(0).getHeight()%></em></span><br/>
                                            <span class="product-thumb-info-act-left"><em>Length: <%=furnitures.get(0).getLength()%></em></span><br/>
                                            <span class="product-thumb-info-act-left"><em>Width: <%=furnitures.get(0).getWidth()%></em></span><br/>
                                            <span class="product-thumb-info-act-left"><em>Price: $<%=furnitures.get(0).getPrice()%>0</em></span>
                                            <br/>
                                            <form action="furnitureProductDetails.jsp">
                                                <input type="hidden" name="sku" value="<%=furnitures.get(0).getSKU()%>"/>
                                                <input type="submit" class="btn btn-primary btn-block" value="More Details"/>
                                            </form>
                                            <%
                                                if (isMemberLoggedIn == true) {
                                            %>
                                            <form action="../../ECommerce_AddFurnitureToListServlet">
                                                <input type="hidden" name="id" value="<%=furnitures.get(0).getId()%>"/>
                                                <input type="hidden" name="SKU" value="<%=furnitures.get(0).getSKU()%>"/>
                                                <input type="hidden" name="price" value="<%=furnitures.get(0).getPrice()%>"/>
                                                <input type="hidden" name="name" value="<%=furnitures.get(0).getName()%>"/>
                                                <input type="hidden" name="imageURL" value="<%=furnitures.get(0).getImageUrl()%>"/>
                                                <input type="submit" name="btnEdit" class="btn btn-primary btn-block" value="Add To Cart"/>
                                            </form>
                                            <%
                                                }
                                            %>
                                        </span>
                                    </span>
                                </li>
                                <%
                                    } catch (Exception ex) {
                                        System.out.println(ex);
                                        ex.printStackTrace();
                                    }
                                %>
                            </ul>
                        </div>
                        <hr class="tall">
                    </div>
                </div>
            </div>
            <jsp:include page="footer.html" />
        </div>
    </body>
</html>
