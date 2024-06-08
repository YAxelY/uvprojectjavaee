<%@ page import="java.util.List" %>
<%@ page import="beans.Profile" %>
 <div class="home-container">
        <!-- Search Bar -->
 		<div class="search-bar">
 		  <div class="menu-button-div">
 		   <span class="menu-button" onclick="toggleSidebar()">  Menu</span>
            <span class="theme-button" onclick="toggleTheme()"> Theme</span>
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
                List<Profile> profiles = (List<Profile>) request.getAttribute("profiles");
                if (profiles != null) {
                    for (Profile profile : profiles) {
            %>
            <div class="card">
                <img src="<%= profile.getPhotoProfile() != null ? profile.getPhotoProfile() : "img/graduation.png" %>" alt="Photo">
                <div class="description">
                    <%= profile.getNomProfile() %> <%= profile.getPrenomProfile() %><br>
                    <%= profile.getEmailProfile() %><br>
                    <%= profile.getTelephoneProfile() %>
                </div>
                <div class="card-actions">
                    <button>View</button>
                    <button>Message</button>
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
            <!-- Add more cards as needed -->
        </div>

        <!-- Offers Section -->
        <div class="offers-section">
            <div class="separator"></div>
            <div class="offers-title">Offers</div>
            <div class="offer-card">
                <img src="offer-photo.jpg" alt="Offer Photo">
                <div class="offer-description">This is a description of the offer.</div>
                <div class="offer-actions">
                    <button>View Offer</button>
                    <button>Contact</button>
                </div>
            </div>
            <div class="offer-card">
                <img src="offer-photo.jpg" alt="Offer Photo">
                <div class="offer-description">This is a description of the offer.</div>
                <div class="offer-actions">
                    <button>View Offer</button>
                    <button>Contact</button>
                </div>
            </div>
            <!-- Add more offer cards as needed -->
            
            
        </div>
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