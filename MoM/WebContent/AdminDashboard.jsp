<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link rel="stylesheet" href="css/dashb.css">
</head>
<title>admin dashboard</title>   
   <body>

        <div class="main-container">

            <!-- HEADER -->
            <header class="block">
                <ul class="header-menu horizontal-list">
                    <li>
                        <a class="header-menu-tab" href="AdminDashboard.jsp"><span class="icon entypo-cog scnd-font-color"></span>Home</a>
                    </li>
                    <li>
                        <a class="header-menu-tab" href="LogoutServlet"><span class="icon fontawesome-user scnd-font-color"></span>Logout</a>
                    </li>
                    
                </ul>
                <div class="profile-menu">
                    <p><%=session.getAttribute("user") %><a href="#26"><span class="entypo-down-open scnd-font-color"></span></a></p>
                
                        <img width="30px" height="30px" alt="Anne Hathaway picture" src="images/user.png" style="border-radius:50%;">
                    
                </div>
            </header>

            <!-- LEFT-CONTAINER -->
            <div class="left-container container">
                <div class="menu-box block"> <!-- MENU BOX (LEFT-CONTAINER) -->
                    <h2 class="titular">ADMIN MENU</h2>
                    <ul class="menu-box-menu">
                        <li>
                            <a class="menu-box-tab" href="Registration_form.html"><span class="icon fontawesome-envelope scnd-font-color"></span>Employee Registration<div class="menu-box-number"></div></a>                            
                        </li>
                        <li>
                            <a class="menu-box-tab" href="view.jsp"><span class="icon entypo-paper-plane scnd-font-color"></span>Employee Details<div class="menu-box-number"></div></a>                            
                        </li>
                        <li>
                            <a class="menu-box-tab" href="Export.html"><span class="icon entypo-calendar scnd-font-color"></span>Export<div class="menu-box-number"></div></a>                            
                        </li>
                                            
                    </ul>
                </div>
		
			
			<div class="left-container container">
                <div class="menu-box block"> <!-- MENU BOX (LEFT-CONTAINER) -->
                    <h2 class="titular">EMPLOYEE MENU</h2>
                    <ul class="menu-box-menu">
                        <li>
                            <a class="menu-box-tab" href="createMom.jsp"><span class="icon fontawesome-envelope scnd-font-color"></span>Create MoM<div class="menu-box-number"></div></a>                            
                        </li>
                        <li>
                            <a class="menu-box-tab" href="#"><span class="icon entypo-paper-plane scnd-font-color"></span>View MoM<div class="menu-box-number"></div></a>                            
                        </li>
                        
                                            
                    </ul>
                </div>
			</div>
			</div>
                
                

            <!-- MIDDLE-CONTAINER -->
            <div class="middle-container container">
                <div class="profile block"> <!--PROFILE (MIDDLE-CONTAINER)--> 
                   <!-- <a class="add-button" href="#28"><span class="icon entypo-plus scnd-font-color"></span></a>
                    <div class="profile-picture big-profile-picture clear">
                        <img width="150px" alt="Anne Hathaway picture" src="card.jpg" >
                    </div>
                    <h1 class="user-name">Anne Hathaway</h1>
                    <div class="profile-description
">
                        <p class="scnd-font-color">Lorem ipsum dolor sit amet consectetuer adipiscing</p>
                    </div>
                    <ul class="profile-options horizontal-list">
                        <li><a class="comments" href="#40"><p><span class="icon fontawesome-comment-alt scnd-font-color"></span>23</li></p></a>
                        <li><a class="views" href="#41"><p><span class="icon fontawesome-eye-open scnd-font-color"></span>841</li></p></a>
                        <li><a class="likes" href="#42"><p><span class="icon fontawesome-heart-empty scnd-font-color"></span>49</li></p></a>
                    </ul>-->
                </div>
            </div>

            
        </div> <!-- end main-container -->
    </body>
</html>

