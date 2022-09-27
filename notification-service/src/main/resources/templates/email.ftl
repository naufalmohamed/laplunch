<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        h2, p, h3{
            margin-left: 20px;
            font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        }
        table{
            width: 100%;
        }
        img{
            border-radius: 10px;
        }

    </style>
</head>
<body>
    <div class="container">
        <div class="row">

            <div class="col" style="border: 1px solid rgb(130, 255, 130);margin-top: 50px;text-align: center;background-image: linear-gradient(to right, #8360c3, #2ebf91);
            ">
                <h1 style="font-family:cursive;color:antiquewhite">LapLunch</h1>
            </div>
        </div>

        <div class="row">
            <div class="col" style="border: 1px solid beige;margin-top: 20px;text-align: left; background-color:rgb(247, 247, 247);">
                <h2 style="font-weight: bold;">Hello,</h2>
                <p style="font-size:larger;font-weight: 200;">
                    Thank you for placing an order with LapLunch. We are committed to serving you with healthy and delicious food.
                    You'll find your order details down below. Hoping to serve you again real soon.
                </p>
            </div>
        </div>

        <div class="row">
            <h2 style="font-weight: bold;margin-top: 10px;" id="seperator">Order Summary</h2>
            <hr>
            <table>
                <tr>
                    <td>
                        <h2 style="font-weight: bold;">Order Number</h2>
                <p style="font-size:medium;font-weight: 200;">
                    ${orderNumber}
                </p>
                    </td>
                    <td>
                        <h2 style="font-weight: bold;">Placed On</h2>
                <p style="font-size:medium;font-weight: 200;">
                    ${placedAt}
                </p>
                    </td>
                    <td>
                        <h2 style="font-weight: bold;">Delivery Time</h2>
                <p style="font-size:medium;font-weight: 200;">
                    ${timeOfDelivery}
                </p>
                    </td>
                </tr>
            </table>
                <table>
                <tr>
                    <td>
                        <h2 style="font-weight: bold;">Address</h2>
                <p style="font-size:medium;font-weight: 200;">
                    ${houseNum},
                    ${Street},
                    ${city},
                    ${state},
                    ${pincode}
                </p>
                    </td>
                </tr>
            </table>

        </div>


    </div>
    <div class="row">
        <h2 style="font-weight: bold;margin-top: 10px;" id="seperator">Ordered Items</h2><hr>
        <table>
            <#list arr2 as a>
            <tr style="background-color:rgb(208, 208, 208)">

                <td>
                    <h3 style="font-weight: normal;margin-top: 10px;">${a.itemName}</h3>
                </td>
                <td>
                    <h3 style="font-weight: normal;margin-top: 10px;">Qty ${a.qty}</h3>
                </td>
                <td>
                    <h3 style="font-weight: normal;margin-top: 10px;">₹${a.itemCost}</h3>
                </td>
            </tr>
            </#list>
        </table>
        <hr>
        <table>
            <tr id="pay">
                            <td>
                                <h3 style="margin-left:30px;">Sub Total</h3>
                            </td>
                            <td>
                                <h3 style="text-align: center;font-weight:normal">₹${totalPrice}</h3>
                            </td>
                        </tr>
                        <tr id="pay">
                            <td>
                                <h3 style="margin-left:30px;">Delivery Charge</h3>
                            </td>
                            <td>
                                <h3 style="text-align: center;font-weight:normal">₹50</h3>
                            </td>
                        </tr>
            <tr id="pay">
                <td>
                    <h3 style="margin-left:30px;">Total</h3>
                </td>
                <td>
                    <h3 style="color:green;text-align: center;">₹${totalPrice+50}</h3>
                </td>
            </tr>
        </table>
        <hr>

    </div>
</body>
</html>