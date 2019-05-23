<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/js-cookie/2.2.0/js.cookie.min.js"></script>
</head>
<body>
    <h1>Hello!</h1>
    <div class="container unauthenticated">
        With Facebook: <a href="/rnd_gradle/login">click here</a>
    </div>
    <div class="container authenticated">
        Logged in as: <span id="user"></span>
        <div>
            <button onClick="logout()" class="btn btn-primary">Logout</button>
        </div>
    </div>
    <script type="text/javascript">
        $.get("/rnd_gradle/user", function(data) {
            $("#user").html(data.userAuthentication.details.name);
            $(".unauthenticated").hide()
            $(".authenticated").show()
        })
        .fail(function(jqXHR, textStatus, errorThrown ) {
            if( jqXHR.status === 401 ) {
                $(".unauthenticated").show();
                $(".authenticated").hide();
            } else {
                alert("error: status: " + jqXHR.status + " error: " + errorThrown);
            }
        });

        var logout = function() {
            $.post("/rnd_gradle/logout", function() {
                $("#user").html('');
                $(".unauthenticated").show();
                $(".authenticated").hide();
            })
            return true;
        }

        $.ajaxSetup({
            beforeSend : function(xhr, settings) {
                if (settings.type == 'POST' || settings.type == 'PUT'
                    || settings.type == 'DELETE') {
                    if (!(/^http:.*/.test(settings.url) || /^https:.*/
                        .test(settings.url))) {
                        // Only send the token to relative URLs i.e. locally.
                        xhr.setRequestHeader("X-XSRF-TOKEN",
                            Cookies.get('XSRF-TOKEN'));
                    }
                }
            }
        });
    </script>
</body>
</html>
