<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
</head>
<body>
<section>
    <div class="container">
        <div class="card">

        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <div class="text-box-detail">
                    원하는 헤어 스타일을
                    <br />
                    미리 정해서 예약할 수 있는
                </div>
                <div class="text-box-title">
                    <h2>미리헤어</h2>
                </div>
            </div>
            <div class="card-body">
                <form>
                    <input type="checkbox" id="email-agree-checkbox">
                    <label for="email-agree-checkbox">이메일 수집 동의 <a href="https://tender-elm-897.notion.site/bdec320429f248e1a71a6363ff381e6d">자세한 내용 보기</a></label>
                    <input type="email" placeholder="이메일을 적어주세요" id="box-email">
                </form>
                <button id="btn-email-send">할인쿠폰 신청하기</button>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="card">
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
</body>

<script src="/js/index.js"></script>
</html>
