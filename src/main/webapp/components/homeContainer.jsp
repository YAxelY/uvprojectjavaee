
   <div class="home-container">
        <!-- Search Bar -->
        <div class="search-bar">
            <div class="menu-button-div">
                <span class="menu-button" onclick="toggleSidebar()">Menu</span>
                <span class="theme-button" onclick="toggleTheme()">Theme</span>
            </div>
            <input type="text" placeholder="Search...">
        </div>

        <!-- Profile Section -->
        <div class="profile-section">
            <div class="profile">
                <h2>Profiles</h2>
            </div>
            <div class="vertical-bar"></div>
            <div class="categories">
                <a href="#">All</a>
                <a href="#">Target</a>
                <a href="#">Subscriptions</a>
            </div>
        </div>

  <!-- Cards Section -->
<div class="cards-section">
    <% 
        List<beans.Profile> profiles = (List<beans.Profile>) request.getAttribute("profiles");
        if (profiles != null && !profiles.isEmpty()) {
            for (beans.Profile profile : profiles) {
    %>
    <div class="card">
        <img src="<%= profile.getPhotoProfile() != null ? profile.getPhotoProfile() : "img/graduation.png" %>" alt="Photo">
        <div class="description">
            <%= profile.getNomProfile() %> <%= profile.getPrenomProfile() %><br>
            <%= profile.getEmailProfile() %><br>
            <%= profile.getTelephoneProfile() %>
        </div>
        <div class="card-actions">
            <!-- View Profile Form -->
            <form action="viewController" method="post">
                <input type="hidden" name="idProfile" value="<%= profile.getIdProfile() %>">
                <input type="hidden" name="username" value="<%= session.getAttribute("username") %>">
                <input type="submit" value="View">
            </form>
            <!-- Message Profile Form -->
            <form action="messageController" method="post">
                <input type="hidden" name="idProfile" value="<%= profile.getIdProfile() %>">
                <input type="hidden" name="username" value="<%= session.getAttribute("username") %>">
                <input type="submit" value="Message">
            </form>
        </div>
    </div>
    <% 
            }
        } else {
    %>
    <div>No profiles found.</div>
    <%
        }
    %>
</div>

    
    
         <script>
        function toggleSidebar() {
            var sidebar = document.getElementById("sidebar");
            if (sidebar.style.display === "block") {
                sidebar.style.display = "none";
            } else {
                sidebar.style.display = "block";
            }
        }

        function toggleTheme() {
            var themeLink = document.getElementById("theme-link");
            if (themeLink.getAttribute("href") === "light-color.css") {
                themeLink.setAttribute("href", "dark-color.css");
            } else {
                themeLink.setAttribute("href", "light-color.css");
            }
        }

        function setInitialTheme() {
            if (window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches) {
                document.getElementById("theme-link").setAttribute("href", "dark-color.css");
            }
        }

        window.onload = setInitialTheme;
    </script>