<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
    .logo {
        display: inline-block;
        width: 670px;
        height: 175px;
        background-image: url("/aop/img/magnified_barcode.png");
        background-position: 1px -75px;
    }

    @-webkit-keyframes blink6 {
        10% { transform: scale(1, 1) rotate(80deg); }
        20% { transform: scale(0, 0) rotate(160deg); }
        100% { transform: scale(0, 0) rotate(0deg); }
    }
    @keyframes blink6 {
        10% { transform: scale(1, 1) rotate(80deg); }
        20% { transform: scale(0, 0) rotate(160deg); }
        100% { transform: scale(0, 0) rotate(0deg); }
    }
    #blink6 {
        position: relative;
        display: inline-block;
        color: #fff;
        text-shadow: 0 0 10px #3d7a97;
    }
    #blink6:after, #blink6:before {
        content: "";
        position: absolute; top: 0; left: 0;
        display: block;
        width: 100px;
        height: 100px;
        background-image:
        radial-gradient(rgba(255,255,255,1), rgba(255,255,255,0) 30%),
        linear-gradient(45deg, rgba(0,0,0,0) 49%, rgba(255,255,255,.4) 50%, rgba(0,0,0,0) 51%),
        linear-gradient(135deg, rgba(0,0,0,0) 49%, rgba(255,255,255,.4) 50%, rgba(0,0,0,0) 51%);
        -webkit-animation: blink6 10s linear infinite;
        animation: blink6 10s linear infinite;
        transform: scale(0, 0) rotate(0deg);
    }
    #blink6:before {
        top: -30%;
        right: 0; left: auto;
        -webkit-animation-delay: 5s;
        animation-delay: 5s;
    }
</style>

<div style="display: inline-block; margin-bottom: -30px;">
    <div style="display: inline-block" class="logo"></div>
    <div id="blink6" style="text-align: center; font-weight: bold; margin-left: 10px; top: -65px; font-size: 95px; color: #66A1DE; font-style: italic;">Audit of Products</div>
</div>