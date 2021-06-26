<%@ include file="header.jsp" %>

<div class="container">
    <div class="row">

        <div class="col-sm-4">
            <form action = "product_all.jsp" method = "GET">
                Product Name: <input type = "text" name = "name">
                <br />
                Product Description: <input type = "text" name = "description" />
                <br />
                Product Price: <input type = "text" name = "price" />
                <br />
                Product Seller: <input type = "text" name = "seller" />
                <input type = "submit" value = "Submit" />
            </form>
        </div>

    </div>
</div><br>

</body>
</html>
