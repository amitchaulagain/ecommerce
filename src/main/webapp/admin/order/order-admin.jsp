<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Meta Tag -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name='copyright' content=''>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Title Tag  -->
    <title>Eshop - eCommerce HTML5 Template.</title>
    <!-- Favicon -->
    <link rel="icon" type="image/png" href="images/favicon.png">
    <!-- Web Font -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap"
          rel="stylesheet">

    <!-- StyleSheet -->

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/magnific-popup.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="css/font-awesome.css">
    <!-- Fancybox -->
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
    <!-- Themify Icons -->
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- Jquery Ui -->
    <link rel="stylesheet" href="css/jquery-ui.css">
    <!-- Nice Select CSS -->
    <link rel="stylesheet" href="css/niceselect.css">
    <!-- Animate CSS -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- Flex Slider CSS -->
    <link rel="stylesheet" href="css/flex-slider.min.css">
    <!-- Owl Carousel -->
    <link rel="stylesheet" href="css/owl-carousel.css">
    <!-- Slicknav -->
    <link rel="stylesheet" href="css/slicknav.min.css">

    <!-- Eshop StyleSheet -->
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">
         <!-- Potta font -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Potta+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/header.css">


</head>
<body class="js">

<!-- Preloader -->
<div class="preloader">
    <div class="preloader-inner">
        <div class="preloader-icon">
            <span></span>
            <span></span>
        </div>
    </div>
</div>
<!-- End Preloader -->

<!-- Header -->

<header class="header shop">
    <!-- Topbar -->
    <!-- Header Inner -->
    <div class="header-inner">
        <div class="container">
            <div class="cat-nav-head">
                <div class="row">
                    <div class="col-12">
                        <div class="menu-area">
                            <!-- Main Menu -->
                            <nav class="navbar navbar-expand-lg">
                                <div class="navbar-collapse">
                                    <div class="nav-inner">
                                        <ul class="nav main-menu menu navbar-nav">
                                            <li class="active"><a href="#">Home</a></li>
                                            <li><a href="#">Product</a></li>
                                            <li><a href="#">Service</a></li>
                                            <li><a href="#">Shop<i class="ti-angle-down"></i><span
                                                    class="new">New</span></a>
                                                <ul class="dropdown">
                                                    <li><a href="shop-grid.html">Shop Grid</a></li>
                                                    <li><a href="cart.html">Cart</a></li>
                                                    <li><a href="checkout.html">Checkout</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="#">Pages</a></li>
                                            <li><a href="#">Blog<i class="ti-angle-down"></i></a>
                                                <ul class="dropdown">
                                                    <li><a href="blog-single-sidebar.html">Blog Single Sidebar</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="contact.html">Contact Us</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>
                            <!--/ End Main Menu -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ End Header Inner -->
</header>
<section class="product-area shop-sidebar shop section">
<div class="text-center mb-0" style="color:green;"><h1 class="text-uppercase ">${entity}</h1></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-4 col-12">
                <div class="shop-sidebar">
                    <!-- Single Widget -->
                    <div class="single-widget category">
                        <h3 class="title">Admin Panel</h3>
                        <ul class="category-list">
                       	<li><a href="/category">Category</a></li>
                        <li><a href="/product">Product</a></li>
                        <li><a href="/order">Order</a></li>
                        </ul>
                    </div>

                </div>
            </div>


            <div class="col-lg-9 col-md-8 col-12">
                <table class="table shopping-summery">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Order Number</th>
                        <th>Total</th>
                        <th>Customer Id</th>
                        <th>Actions</th>
                    </tr>
                    </thead>

    <c:forEach var="oneOrder" items="${orderList}" >
            <tr class="text-center">
                <td><c:out value="${oneOrder.id}" /></td>
                <td><c:out value="${oneOrder.order_number}" /></td>
                <td><c:out value="${oneOrder.total}" /></td>
                <td><c:out value="${oneOrder.customer_id}" /></td>

                <td>
                 <a  role="button" style="color:white; padding:1px 5px 1px 5px;" class="btn"
                                            href="/user?id=<c:out value="${oneOrder.id }"/>">Details</a>
                <a  role="button"style="color:white; padding:1px 5px 1px 5px;" class="btn"
                    href="/editUser?id=<c:out value="${oneOrder.id }"/>">Update</a>

                <a  role="button" style="color:white; padding:1px 5px 1px 5px;" class="btn"
                    method ="D" href="/user?id=<c:out value="${oneOrder.id }"/>">Delete</a>

                </td>

            </tr>
        </c:forEach>
                    </tbody>
                </table>


            </div>
        </div>
    </div>
    </div>
</section>
<!--/ End Product Style 1  -->

<!-- Start Shop Newsletter  -->
<!-- End Shop Newsletter -->


<!-- Modal -->
<!-- Modal end -->

<!-- Start Footer Area -->
<!-- /End Footer Area -->


<!-- Jquery -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate-3.0.0.js"></script>
<script src="js/jquery-ui.min.js"></script>
<!-- Popper JS -->
<script src="js/popper.min.js"></script>
<!-- Bootstrap JS -->
<script src="js/bootstrap.min.js"></script>
<!-- Color JS -->
<script src="js/colors.js"></script>
<!-- Slicknav JS -->
<script src="js/slicknav.min.js"></script>
<!-- Owl Carousel JS -->
<script src="js/owl-carousel.js"></script>
<!-- Magnific Popup JS -->
<script src="js/magnific-popup.js"></script>
<!-- Fancybox JS -->
<script src="js/facnybox.min.js"></script>
<!-- Waypoints JS -->
<script src="js/waypoints.min.js"></script>
<!-- Countdown JS -->
<script src="js/finalcountdown.min.js"></script>
<!-- Nice Select JS -->
<script src="js/nicesellect.js"></script>
<!-- Ytplayer JS -->
<script src="js/ytplayer.min.js"></script>
<!-- Flex Slider JS -->
<script src="js/flex-slider.js"></script>
<!-- ScrollUp JS -->
<script src="js/scrollup.js"></script>
<!-- Onepage Nav JS -->
<script src="js/onepage-nav.min.js"></script>
<!-- Easing JS -->
<script src="js/easing.js"></script>
<!-- Active JS -->
<script src="js/active.js"></script>
</body>
</html>