<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/"> <img src="/img/logo.png" style="width:3rem; height: 3rem;"> 미리헤어</a>
</nav>
<section>
    <div class="container" style="margin-top:5rem">
        <div class="card border-0">
            <div class="head-container">
                <div class="head-container-wrapper1">
                    <div class="text-box-title head-box1">
                        <div class="d-flex justify-content-center">
                            <h1>머리 어떻게 해드릴까요?</h1>
                        </div>
                        <div class="d-flex justify-content-center"><img src="/img/smiling_face_3d.png"/></div>
                    </div>
                </div>
                <div class="head-container-wrapper2">
                    <div class="text-box-title head-box2">
                        <div class="d-flex justify-content-center"><img src="/img/anxious_face_with_sweat_3d.png"/></div>
                        <div class="d-flex justify-content-center flex-column align-items-center">
                            <h1>제대로 말하지 못했다면?</h1>
                        </div>
                    </div>
                </div>
                <div class="head-container-wrapper3">
                    <div class="text-box-title head-box3">
                        <div class="d-flex justify-content-center"><img src="/img/logo.png" style="height: 10rem; width: 10rem;"/></div>
                        <div class="d-flex justify-content-center flex-column align-items-center">
                            <div class="text-box-detail d-flex flex-column align-items-center">
                                <h3>원하는 스타일을</h3>
                                <h3>미리 정해서 예약할 수 있는</h3>
                                <br />
                                <h1>미리헤어 !</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<hr />
<section>
    <div class="container">
        <div class="card border-0">
            <div class="card-body">
                <span>이메일을 남겨주시면</span>
                <span>서비스 런칭시 사용할 수 있는</span>
                <span>할인 쿠폰을 보내드립니다.</span>
                <div class="d-flex justify-content-center"><img src="/img/hugging_face_3d.png"/></div>
                <div class="d-flex justify-content-center"><img src="/img/incoming_envelope_3d.png"/></div>
                <div class="d-flex justify-content-center"><img src="/img/open_mailbox_with_lowered_flag_3d.png"/></div>
                <div class="d-flex justify-content-center"><img src="/img/open_mailbox_with_raised_flag_3d.png"/></div>
                <div class="d-flex justify-content-center"><img src="/img/smiling_face_with_heart-eyes_3d.png"/></div>
            </div>
            <div class="card-body">
                <form>
                    <input type="checkbox" id="email-agree-checkbox">
                    <label for="email-agree-checkbox">이메일 수집 동의 <a href="https://tender-elm-897.notion.site/bdec320429f248e1a71a6363ff381e6d">자세한 내용 보기</a></label>
                    <input type="email" placeholder="이메일을 적어주세요" id="box-email">
                </form>
                <button id="btn-email-send" class="btn btn-primary btn-lg">할인쿠폰 신청하기</button>
            </div>
        </div>
    </div>
</section>
<hr />
<section>
    <div class="container">
        <div class="card border-0">
            <div class="card-body">
                <div class="text-box-detail">
                    디자이너별 미용 후기 및
                    <br />
                    포트폴리오 모아보기 기능을 통해
                    <br />
                    원하는 스타일을 찾아볼 수도 있고
                </div>
            </div>
            <div class="card-body">
                <div class="text-box-detail">
                    원하는 스타일이 없는 경우
                    <br />
                    나만의 스타일 찾기를 통해
                    <br />
                    적합한 스타일을 추천받을 수 있습니다.
                </div>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="card border-0">
            <div class="card-body">
                <div class="text-box-footer">
                    Today Visitors : ${todayCount}
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<footer class="text-center text-white" style="background-color: #f1f1f1;">
    <!-- Grid container -->
    <%--<div class="container pt-4">
        <!-- Section: Social media -->
        <section class="mb-4">
            &lt;%&ndash;<!-- Facebook -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-facebook-f"></i
            ></a>

            <!-- Twitter -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-twitter"></i
            ></a>&ndash;%&gt;

            &lt;%&ndash;<!-- Google -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-google"></i
            ></a>&ndash;%&gt;

            <!-- Instagram -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-instagram"></i
            ></a>

           &lt;%&ndash; <!-- Linkedin -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-linkedin"></i
            ></a>&ndash;%&gt;
            &lt;%&ndash;<!-- Github -->
            <a
                    class="btn btn-link btn-floating btn-lg text-dark m-1"
                    href="#!"
                    role="button"
                    data-mdb-ripple-color="dark"
            ><i class="fab fa-github"></i
            ></a>&ndash;%&gt;
        </section>
        <!-- Section: Social media -->
    </div>
    <!-- Grid container -->--%>

    <!-- Copyright -->
    <div class="text-center text-dark p-3" style="background-color: rgba(0, 0, 0, 0.1);">
        © 2023 Copyright:
        <a class="text-dark" href="#">miri_hair.com</a>
    </div>
    <!-- Copyright -->
</footer>
<script src="/js/index.js"></script>
</html>
