<%@ page import="model.*" %>
<%@ page import="controller.*" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IoTBay - Home</title>
    <link href="css/welcome.css" rel="stylesheet" type="text/css">
    <link href="css/product.css" rel="stylesheet" type="text/css">

</head>
<body>
        <%
            if ("logout".equals(request.getParameter("action"))) {
                    session.removeAttribute("loggedUser");
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                    return;
                }

            UserController userController = (UserController) session.getAttribute("userController");
            if (userController == null) {
                userController = new UserController();
                session.setAttribute("userController", userController);
            }
            User loggedUser = (User) session.getAttribute("loggedUser");

            //ADD TO THIS ARRAY FOR NOW AND IT WILL AUTOMATICALLY DISPLAY ON WELCOME PAGE
            Product products[] = {  new Product(001,"10V Battery", 100, 9.50),
                                    new Product(002,"20V Battery", 100, 13.50),
                                    new Product(003,"30V Battery", 100, 17.50),
                                    new Product(004,"Arduino UNO", 100, 30.00),
                                    new Product(005,"5V Relay", 100, 8.50),
                                    

            };
        %>
    <header>
    <nav>
        <div class="navbar">
    <form action="index.jsp" method="post">
        <input class="baritem button" style="font-size: 20px;" type="submit" value="Home">
    </form>
       <form action="deals.jsp" method="post">
        <input class="baritem button" style="font-size: 20px;" type="submit" value="Deals">
    </form>
    <form action="cart.jsp" method="post">
        <input class="baritem button" style="font-size: 20px;"  type="submit" value="Cart">
    </form>

<div class="search-bar">
        <input style="width: 100%;
    padding: 12px 50px;
    margin-bottom: 2px;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;" type="text" placeholder="Search...">
    </div>
    <div style="
    display: flex;
    gap: 10px;
    align-items: center;
    font-size: 20px;">
        <% if (loggedUser != null) { %>
            <span class="user-info" style="color: white;" >Welcome, <%= loggedUser.getName() %></span>
            <a href="edit_info.jsp" class="baritem button">My Account</a>
            <form action="index.jsp" method="post" >
                <input type="hidden" name="action" value="logout">
                <input class="button" type="submit" value="Log Out">
            </form>
        <% } else { %>
            <a href="login.jsp" class="baritem button">Login</a>
            <a href="register.jsp" class="baritem button">Register</a>
        <% } %>
    </div>
</div>
    </header>
    </nav>

        <section id="product">
            <div class="row">
                <% for (int index = 0 ; index < products.length ; index ++) { %>   
                    <div class="course-col">
                        <img src="css/images/image copy 4.png"><br>
                        <label><%= products[index].getProductName() %></label>
                        <label><%= String.format("$%.2f", products[index].getPrice()) %></label>
                        <input class="cart-button" type="submit" value="Add to cart"><br>
                    </div>
                <% } %>
            </div>
        </section>

            <div class="features">
                <div class="feature">
                    <h3></h3>
                    <p></p>
                </div>
                <div class="feature">
                    <h3></h3>
                    <p></p>
                </div>
                <div class="feature">
                    <h3></h3>
                    <p></p>
                </div>
            </div>
        </section>

        <section id="about">
        </section>
        <section id="contact">
        </section>
    </div>
    <footer>
        <div class="container">
            <p>&copy; 2025 IoTBay</p>
        </div>
    </footer>
</body>
</html>