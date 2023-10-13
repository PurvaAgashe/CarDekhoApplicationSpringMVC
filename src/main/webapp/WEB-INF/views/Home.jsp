<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="NavBar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CarDekhoApp</title>
<style>
h1{
color: black;
}
.img1{
margin-top:50px;
width: 1100px;
height: 400px
}
      .container {
            display: flex;
            align-items: center;
            justify-content: center;
            flex-wrap: wrap;
        }
.leftbar{
margin-left:10px;
margin-top:50px;
height: 400px;
width: 200px;
  border: 1px solid;
  padding: 10px;
  box-shadow: 5px 10px graytext;
}
   .brand-container {
            width: 90%;
            margin: 0 auto;
            text-align: center;
        }

        h2 {
            font-size: 24px;
            color: #333;
        }
.brand-box {
            display: inline-block;
            margin: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
            width: 150px;
        }
  .brand-logo {
            max-width: 100%;
            height: auto;
        }
.brand-name {
            margin-top: 10px;
            font-weight: bold;
        }
</style>
</head>
<body>
<div align="center">
<h1>FIND YOUR RIGHT CAR HERE! </h1>
<div class="container">
<div class="leftbar">
<p>Launched</p>
<p>Get design &features Upgrades</p>
<h2>New Tata Nexon</h2>
<p>Know More</p>
</div>
<img class="img1" alt="no image found" src="https://static.toiimg.com/photo/msid-97083880/97083880.jpg">

</div>
<div>

</div>
<div class="brand-container">
        <h2>Our Brands</h2>
        <div class="brand-box">
            <img class="brand-logo" src="https://stimg.cardekho.com/pwa/img/brandLogo_168x84/maruti.jpg" alt="Brand 1 Logo">
            <div class="brand-name">Maruti</div>
        </div>
        <div class="brand-box">
            <img class="brand-logo" src="https://stimg.cardekho.com/pwa/img/brandLogo_168x84/tata.jpg" alt="Brand 2 Logo">
            <div class="brand-name">TaTa</div>
        </div>
        <div class="brand-box">
            <img class="brand-logo" src="https://stimg.cardekho.com/pwa/img/brandLogo_168x84/kia.jpg" alt="Brand 3 Logo">
            <div class="brand-name">KIA</div>
        </div>
        <div class="brand-box">
            <img class="brand-logo" src="https://stimg.cardekho.com/pwa/img/brandLogo_168x84/toyota.jpg" alt="Brand 4 Logo">
            <div class="brand-name">Toyota</div>
        </div>
        <div class="brand-box">
            <img class="brand-logo" src="https://stimg.cardekho.com/pwa/img/brandLogo_168x84/mahindra.jpg" alt="Brand 5 Logo">
            <div class="brand-name">Mahindra</div>
        </div>
        <div class="brand-box">
            <img class="brand-logo" src="https://stimg.cardekho.com/pwa/img/brandLogo_168x84/hyundai.jpg" alt="Brand 5 Logo">
            <div class="brand-name">Hyundai</div>
        </div>
    </div>
</div>
<h1>HAVE A NICE DAY</h1>

</body>
</html>