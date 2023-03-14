<jsp:include page="../Header/Header.jsp" />
<body>
<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <h3 class="text-center">Login Admin</h3>
                <form role="form" action="/admin/login" id="contact-form" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="mb-4">
                            <div class="input-group input-group-dynamic">
                                <label class="form-label">Username</label>
                                <input type="text" class="form-control" name="username">
                            </div>
                        </div>
                        <div class="mb-4">
                            <div class="input-group input-group-dynamic">
                                <label class="form-label">Password</label>
                                <input type="password" class="form-control" name="mdp">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn bg-gradient-dark w-100">Sign Up</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
<jsp:include page="../Footer.jsp" />
