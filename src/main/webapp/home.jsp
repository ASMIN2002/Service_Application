<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HOME PAGE</title>
<link rel="stylesheet" href="setting.css">
<link rel="stylesheet" href="home.css">

</head>

<body>
	<header>
		<div class="wrapper">
			<div class="logo">BEST OF LUCK</div>
			<nav class="menu">
				<ul>
					<li><a href="home.jsp">HOME</a></li>
					<li><a href="service.html">SERVICES</a></li>
					<li><a href="contact.html">CONTACT US</a></li>
					<li><a href="#" class="toggle-link" aria-expanded="false"
						aria-controls="child">Setting</a></li>
				</ul>
			</nav>
		</div>
		<div id="child">
			<a href="#" class="re-toggle-link" aria-expanded="false"
				aria-controls="child"> <?xml version="1.0" ?> <!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.1//EN' 'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'>
				<svg height="52px" id="Layer_1"
					style="enable-background: new 0 0 512 512;" version="1.1"
					viewBox="0 0 512 512" width="512px" xml:space="preserve"
					xmlns="http://www.w3.org/2000/svg"
					xmlns:xlink="http://www.w3.org/1999/xlink">
                    <polygon
						points="64.5,256.5 256.5,448.5 256.5,336.5 448.5,336.5 448.5,176.5 256.5,176.5 256.5,64.5 " />
                </svg>
			<form action="dpdev" method="post">
				
				<%-- <h3 style='text-decoration: none;color: white;'>USER NAME : ${name}</h3>

				<h4 style='text-decoration: none;color: white;'>Email : ${email}</h4>

				<h4 style='text-decoration: none;color: white;'>Password : ${pass}</h4> --%>

				<button
					style="margin-top: 142px; margin-left: 38%; background-color: black;">
					<a href="index.html"
						style="text-decoration: none; color: blue; font-weight: bold; padding: 10px 10px;">LOG
						OUT</a>
				</button>

				<button
					style="margin-top: 142px; margin-left: 29%; background-color: black;height:35px;color:red" name="delete">
					
						DELETE
						ACCOUNT
				</button>
			</form>
		</div>
		<div class="text">
			<h1>LET'S BUILD</h1>
			<p>Join Us For Your Better Future.</p>
		</div>
	</header>
	<script>
        document.addEventListener('DOMContentLoaded', () => {
            let isExpanded = false;
            const child = document.getElementById("child");
            const toggleLink = document.querySelector(".toggle-link");
            const reToggleLink = document.querySelector(".re-toggle-link");

            function toggleChild() {
                isExpanded = !isExpanded;
                child.style.right = isExpanded ? "0" : "-39rem";
                toggleLink.setAttribute('aria-expanded', isExpanded);
                reToggleLink.setAttribute('aria-expanded', isExpanded);
                console.log(isExpanded ? "Expanded" : "Collapsed");
            }

            toggleLink.addEventListener('click', (event) => {
                event.preventDefault();
                toggleChild();
            });

            reToggleLink.addEventListener('click', (event) => {
                event.preventDefault();
                toggleChild();
            });
        });
    </script>
</body>

</html>