<%@tag description="Simple Template" pageEncoding="UTF-8"  %>

<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="description" content="Configuratore">
    <meta name="author" content="Davide Nava">
    <meta property="og:title" content="Configuratore">
    <meta property="og:type" content="website">
    <!-- <meta property="og:url" content="https://www.sitepoint.com/a-basic-html5-template/"> -->
    <meta property="og:description" content="Configuratore">
    <!-- <meta property="og:image" content="image.png"> -->
    <link rel="icon" href="/img/favicon.ico">
    <link rel="icon" href="/img/favicon.svg" type="image/svg+xml">
    <link rel="apple-touch-icon" href="/apple-touch-icon.png">


    <script src="/js/jquery.min.js"></script>

    <script>window.jQuery || document.write(decodeURIComponent('%3Cscript src="js/jquery.min.js"%3E%3C/script%3E'))</script>

    <link rel="stylesheet" type="text/css" href="/lib/devepress/css/dx.common.css" />
    <link rel="stylesheet" type="text/css" href="/lib/devepress/css/dx.light.css" />


    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/plugins/toastr/toastr.min.css" rel="stylesheet">

    <link href="js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <script src="/lib/devepress/js/dx.all.js"></script>

    <link rel="stylesheet" href="/css/configurator.css">

    <title>${title}</title>

    <jsp:invoke fragment="head_area"/>

</head>
<body>
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav metismenu" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="block m-t-xs font-bold">Configuratore</span>
                            </a>
                        </div>
                        <div class="logo-element">
                            ND
                        </div>
                    </li>
                    <li>
                        <a href="/tables/ArticleArticleGroupType.jsp"><i class="fa fa-table"></i> <span class="nav-label">ArticleArticleGroupType</span></a>
                    </li>
                    <li>
                        <a href="/tables/Article.jsp"><i class="fa fa-table"></i> <span class="nav-label">Article</span></a>
                    </li>
                    <li>
                        <a href="/tables/ArticleGroupType.jsp"><i class="fa fa-table"></i> <span class="nav-label">ArticleGroupType</span></a>
                    </li>
                    <li>
                        <a href="/tables/ArticleMachine.jsp"><i class="fa fa-table"></i> <span class="nav-label">ArticleMachine</span></a>
                    </li>
                    <li>
                        <a href="/tables/ArticleMachineType.jsp"><i class="fa fa-table"></i> <span class="nav-label">ArticleMachineType</span></a>
                    </li>
                    <li>
                        <a href=/tables/ArticleType.jsp"><i class="fa fa-table"></i> <span class="nav-label">ArticleType</span></a>
                    </li>
                    <li>
                        <a href="/tables/Customer.jsp"><i class="fa fa-table"></i> <span class="nav-label">Customer</span></a>
                    </li>
                    <li>
                        <a href="/tables/InvoiceEntity.jsp"><i class="fa fa-table"></i> <span class="nav-label">Invoice</span></a>
                    </li>
                    <li>
                        <a href="/tables/InvoiceItem.jsp"><i class="fa fa-table"></i> <span class="nav-label">InvoiceItem</span></a>
                    </li>
                    <li>
                        <a href="/tables/Machine.jsp"><i class="fa fa-table"></i> <span class="nav-label">Machine</span></a>
                    </li>
                    <li>
                        <a href="/tables/MachineType.jsp"><i class="fa fa-table"></i> <span class="nav-label">Machine</span></a>
                    </li>
                </ul>
            </div>
        </nav>

        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li style="padding: 20px">
                            <span class="m-r-sm text-muted welcome-message">Welcome to configurator.</span>
                        </li>
                    </ul>
                </nav>
            </div>

            <div class="wrapper wrapper-content">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox ">
                                    <div class="ibox-title">
                                        <h5>Read below comments</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link" href="">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                                <i class="fa fa-wrench"></i>
                                            </a>
                                            <ul class="dropdown-menu dropdown-user">
                                                <li><a href="#" class="dropdown-item">Config option 1</a>
                                                </li>
                                                <li><a href="#" class="dropdown-item">Config option 2</a>
                                                </li>
                                            </ul>
                                            <a class="close-link" href="">
                                                <i class="fa fa-times"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="ibox-content no-padding">
                                        <ul class="list-group">
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Alan Marry</a> I belive that. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 1 minuts ago</small>
                                            </li>
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Stock Man</a> Check this stock chart. This price is crazy! </p>
                                                <div class="text-center m">
                                                    <span id="sparkline8"></span>
                                                </div>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 2 hours ago</small>
                                            </li>
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Kevin Smith</a> Lorem ipsum unknown printer took a galley </p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 2 minuts ago</small>
                                            </li>
                                            <li class="list-group-item ">
                                                <p><a class="text-info" href="#">@Jonathan Febrick</a> The standard chunk of Lorem Ipsum</p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 1 hour ago</small>
                                            </li>
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Alan Marry</a> I belive that. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 1 minuts ago</small>
                                            </li>
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Kevin Smith</a> Lorem ipsum unknown printer took a galley </p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 2 minuts ago</small>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="footer">
                <div class="float-right">
                    Configuratore
                </div>
                <div>
                    <strong>Copyright</strong> Nava Davide &copy; 2022
                </div>
            </div>
        </div>
    </div>

    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <script src="js/plugins/flot/jquery.flot.js"></script>
    <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="js/plugins/flot/jquery.flot.pie.js"></script>

    <script src="js/plugins/peity/jquery.peity.min.js"></script>

    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>

    <script src="js/plugins/gritter/jquery.gritter.min.js"></script>

    <script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>

    <script src="js/plugins/toastr/toastr.min.js"></script>

<script type="text/javascript" src="/js/configurator.js"></script>

</body>
</html>