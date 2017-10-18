<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	
	<!-- title and meta -->
	<!-- <meta charset="utf-8" /> -->
	<meta name="viewport" content="width=device-width,initial-scale=1.0" />
	<meta name="description" content="" />
	<title>Header Resize On Scroll with Animations</title>
	    
	<!-- css -->
	<link href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,700,400italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
	 <style type="text/css">
				/* =Reset default browser CSS. Based on work by Eric Meyer: http://meyerweb.com/eric/tools/css/reset/index.html
	-------------------------------------------------------------- */
	html, body, div, span, applet, object, iframe,
	h1, h2, h3, h4, h5, h6, p, blockquote, pre,
	a, abbr, acronym, address, big, cite, code,
	del, dfn, em, font, img, ins, kbd, q, s, samp,
	small, strike, strong, sub, sup, tt, var,
	b, u, i, center,
	dl, dt, dd, ol, ul, li,
	fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td {
	  background: transparent;
	  border: 0;
	  margin: 0;
	  padding: 0;
	  vertical-align: baseline; }
	
	body {
	  line-height: 1; }
	
	h1, h2, h3, h4, h5, h6 {
	  clear: both;
	  font-weight: normal; }
	
	ol, ul {
	  list-style: none; }
	
	blockquote {
	  quotes: none; }
	
	blockquote:before, blockquote:after {
	  content: '';
	  content: none; }
	
	del {
	  text-decoration: line-through; }
	
	/* tables still need 'cellspacing="0"' in the markup */
   	  table {  
  	  border-collapse: collapse;
  	  border-spacing: 0; } 
		a img {
	  border: none; }	
	/* =Scss Variables
	-------------------------------------------------------------- */
	/* =Global
	-------------------------------------------------------------- */
	*,
	*:before,
	*:after {
	  -webkit-box-sizing: border-box;
	  -moz-box-sizing: border-box;
	  box-sizing: border-box; }
	
	body {
	  background-color: #3cb5f9;
	  color: #505050;
	  font-family: "Ubuntu", sans-serif;
	  font-weight: 300;
	  font-size: 16px;
	  line-height: 1.8; }
	
	/* Headings */
	h1, h2, h3, h4, h5, h6 {
	  line-height: 1;
	  font-weight: 300; }
	
	a {
	  text-decoration: none;
	  color: #3cb5f9; }
	
	a:hover {
	  color: #0793e2; }
	
	/* =Template
	-------------------------------------------------------------- */
		
		
	/* =Header
	-------------------------------------------------------------- */
	header {
	  width: 100%;
	  height: 150px;
	  overflow: hidden;
	  position: fixed;
	  top: 0;
	  left: 0;
	  z-index: 999;
	  background-color: #0683c9;
	  -webkit-transition: height 0.3s;
	  -moz-transition: height 0.3s;
	  -ms-transition: height 0.3s;
	  -o-transition: height 0.3s;
	  transition: height 0.3s; }
	  header h1#logo {
	    display: inline-block;
	    height: 150px;
	    line-height: 150px;
	    float: left;
	    font-family: "Oswald", sans-serif;
	    font-size: 60px;
	    color: white;
	    font-weight: 400;
	    -webkit-transition: all 0.3s;
	    -moz-transition: all 0.3s;
	    -ms-transition: all 0.3s;
	    -o-transition: all 0.3s;
	    transition: all 0.3s; }
	  header nav {
	    display: inline-block;
	    float: right; }
	    header nav a {
	      line-height: 150px;
	      margin-left: 20px;
	      color: #9fdbfc;
	      font-weight: 700;
	      font-size: 18px;
	      -webkit-transition: all 0.3s;
	      -moz-transition: all 0.3s;
	      -ms-transition: all 0.3s;
	      -o-transition: all 0.3s;
	      transition: all 0.3s; }
	      header nav a:hover {
	        color: white; }
	  header.smaller {
	    height: 75px; }
	    header.smaller h1#logo {
	      width: 150px;
	      height: 75px;
	      line-height: 75px;
	      font-size: 30px; }
	    header.smaller nav a {
	      line-height: 75px; }
	
	/* =Footer
	-------------------------------------------------------------- */
	/* =Extras
	-------------------------------------------------------------- */
	.clearfix:after {
	  visibility: hidden;
	  display: block;
	  content: "";
	  clear: both;
	  height: 0; }
	
	/* =Media Queries
	-------------------------------------------------------------- */
	@media all and (max-width: 660px) {
	  /* =Header
	  -------------------------------------------------------------- */
	  header h1#logo {
	    display: block;
	    float: none;
	    margin: 0 auto;
	    height: 100px;
	    line-height: 100px;
	    text-align: center; }
	  header nav {
	    display: block;
	    float: none;
	    height: 50px;
	    text-align: center;
	    margin: 0 auto; }
	    header nav a {
	      line-height: 50px;
	      margin: 0 10px; }
	  header.smaller {
	    height: 75px; }
	    header.smaller h1#logo {
	      height: 40px;
	      line-height: 40px;
	      font-size: 30px; }
	    header.smaller nav {
	      height: 35px; }
	      header.smaller nav a {
	        line-height: 35px; } }
	@media all and (max-width: 600px) {
	  .container {
	    width: 100%; }
	} 
	
			</style>	   
	<!-- js -->
	<script type="text/javascript">
	/*!
	 * classie v1.0.0
	 * class helper functions
	 * from bonzo https://github.com/ded/bonzo
	 * MIT license
	 * 
	 * classie.has( elem, 'my-class' ) -> true/false
	 * classie.add( elem, 'my-new-class' )
	 * classie.remove( elem, 'my-unwanted-class' )
	 * classie.toggle( elem, 'my-class' )
	 */
	
	/*jshint browser: true, strict: true, undef: true, unused: true */
	/*global define: false */
	
	( function( window ) {
	
	'use strict';
	
	// class helper functions from bonzo https://github.com/ded/bonzo
	
	function classReg( className ) {
	  return new RegExp("(^|\\s+)" + className + "(\\s+|$)");
	}
	
	// classList support for class management
	// altho to be fair, the api sucks because it won't accept multiple classes at once
	var hasClass, addClass, removeClass;
	
	if ( 'classList' in document.documentElement ) {
	  hasClass = function( elem, c ) {
	    return elem.classList.contains( c );
	  };
	  addClass = function( elem, c ) {
	    elem.classList.add( c );
	  };
	  removeClass = function( elem, c ) {
	    elem.classList.remove( c );
	  };
	}
	else {
	  hasClass = function( elem, c ) {
	    return classReg( c ).test( elem.className );
	  };
	  addClass = function( elem, c ) {
	    if ( !hasClass( elem, c ) ) {
	      elem.className = elem.className + ' ' + c;
	    }
	  };
	  removeClass = function( elem, c ) {
	    elem.className = elem.className.replace( classReg( c ), ' ' );
	  };
	}
	
	function toggleClass( elem, c ) {
	  var fn = hasClass( elem, c ) ? removeClass : addClass;
	  fn( elem, c );
	}
	
	var classie = {
	  // full names
	  hasClass: hasClass,
	  addClass: addClass,
	  removeClass: removeClass,
	  toggleClass: toggleClass,
	  // short names
	  has: hasClass,
	  add: addClass,
	  remove: removeClass,
	  toggle: toggleClass
	};
	
	// transport
	if ( typeof define === 'function' && define.amd ) {
	  // AMD
	  define( classie );
	} else {
	  // browser global
	  window.classie = classie;
	}
	
	})( window );
	
	</script>
	<script>
	    function init() {
	        window.addEventListener('scroll', function(e){
	            var distanceY = window.pageYOffset || document.documentElement.scrollTop,
	                shrinkOn = 600,
	                header = document.querySelector("header");
	            if (distanceY > shrinkOn) {
	                classie.add(header,"smaller");
	            } else {
	                if (classie.has(header,"smaller")) {
	                    classie.remove(header,"smaller");
	                }
	            }
	        });
	    }
	    window.onload = init();
	</script>
	</head>
	
	
	
	<body>
<!-- 	<div id="wrapper"> -->
	<header>
	    <div class="container clearfix">
	        <h1 id="logo">
	            Shukla Group of Institutions
	        </h1>
	        <nav>
	            <a href = "getHomePage.do">Home</a>
	            <a href = "getHomePage.do">Program List</a>
	            <a href="javascript:void(0)" >Contact Us</a>
	        </nav>
	        </div>
	</header><!-- /header -->
<!-- 			</div> -->
	</body>
</html>