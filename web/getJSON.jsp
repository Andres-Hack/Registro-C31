<%-- 
    Document   : getJSON
    Created on : 07-03-2018, 03:51:47 PM
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script src="http://code.jquery.com/jquery-1.7.js"
            type="text/javascript"></script>
        <script
            src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
            type="text/javascript"></script>
        <link
            href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
            rel="stylesheet" type="text/css" />
        <STYLE TYPE="text/css" media="all">
        .ui-autocomplete { 
            position: absolute; 
            cursor: default; 
            height: 200px; 
            overflow-y: scroll; 
            overflow-x: hidden;}
        </STYLE>

        <script type="text/javascript">
        $(document).ready(function() {
            $("input#autoText").autocomplete({
                width: 300,
                max: 10,
                delay: 100,
                minLength: 1,
                autoFocus: true,
                cacheLength: 1,
                scroll: true,
                highlight: false,
                source: function(request, response) {
                    $.ajax({
                        url: "/registroC31/EjemploJSON",
                        dataType: "application/json",
                        data: request,
                        success: function( data, textStatus, jqXHR) {
                            console.log( data.subcomponente);
                            var items = data.subcomponente.codigo;
                            response(items);
                        },
                        error: function(jqXHR, textStatus, errorThrown){
                             console.log( textStatus);
                        }
                    });
                }

            });
        });

        </script>
    </head>
    <body ng-app="myApp">
        <h1>jQuery Autocomplete Example</h1>
        <p>In this example we will have an input box that will provide
            suggestions using autocomplete( url or data, options ) and Ajax
            request.</p>
        <form name="as400samplecode" action="" method="get">

            <table>

                <tr>
                    <td><input id="autoText" maxlength="20" />
                    </td>
                </tr>

            </table>

        </form>
    </body>
</html>