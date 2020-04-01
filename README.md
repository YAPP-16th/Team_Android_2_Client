[![Issues][issues-shield]][issues-url]
[![Pulls][pulls-shield]][pulls-url]
[![MIT License][license-shield]][license-url]

## YAPP 16기 [안드로이드 2팀 - 팀플레이(TeamPlay)]

<br />
<p align="center">
  <a href="https://github.com/github_username/repo">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
    [프로젝트 로고 대체]
  </a>

  <h3 align="center">팀플레이(TeamPlay)</h3>

  <p align="center">
    프로젝트 한줄 설명
    <ul>
        <li>PM - 최민성</li>
        <li>Designer - 김성규</li>
        <li>Android - 오준택, 최창익, 이오형</li>
        <li>Backend - 오성진, 최민성</li>
    </ul>
    <br />
    스크럼 회의록<br>
    <a href="https://docs.google.com/document/d/1AwAr7X_wwrbUWcQipvEMq6PF71IJJzm3U0lVygvCdD0/edit">- 2020/03/18</a><br>
    <a href="https://docs.google.com/document/d/1k7en4Bh3_725r84Ec62UktykB5owpzijEYQ6GpFoBY8/edit#">- 2020/03/25</a><br>
    <a href="https://docs.google.com/document/d/1ZzF5moWa2PcaX6NZF-YfGRRNO5HfYCOwkdiCYC7VSqo/edit">- 2020/03/28</a><br>
    <a href="https://docs.google.com/document/d/1LU_6dQeyIGKo3tyJOiEmIRVc2p3LwNJtBpQLHUNIaRQ/edit">- 2020/03/31</a><br>
    <br />
    <a href="https://github.com/github_username/repo"><strong>API</strong></a>
    <br />
    <br />
    <a href="https://github.com/YAPP-16th/Team_Android_2_Client">View Demo</a>
        ·
        <a href="https://github.com/YAPP-16th/Team_Android_2_Backend/issues/new?template=bug_report.md">Report Bug</a>
        ·
        <a href="https://github.com/YAPP-16th/Team_Android_2_Backend/issues/new?template=future_request.md">Request Feature</a>
  </p>
</p>

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About The Project](#about-the-project)
    * [Build With](#build-with)
* [App Architecture](#app-architecture)
* [Contributing](#contributing)
    * [Git Flow Plugin](#git-flow-plugin)
* [License](#license)
* [Contact](#contact)

## About The Project

To get a local copy up and running follow these simple steps.

### Build With

<!-- App Architecture -->
## App Architecuture

이 앱은 Clean Architecture 패턴으로 총 3개의 레이어로 구성되있습니다.

- **Domain**
- **Data**
- **Presentation**

### Presentation Architecture - MVVM

UI 관련 패키지인 Presentation은 MVVM으로 설계했습니다.
우리는 유지보수 및 추후 확장성을 고려한 아키텍쳐를 선택했습니다. 의존성을 분리하고 모듈화를 위해 뷰모델을 활용한 MVVM 패턴을 적용하고,
뷰모델에서 뷰를 갱신하기 위해 Observable 형태나 DataBinding을 활용해서 알립니다.
MVVM의 구성요소는 다음과 같습니다.

### 모델
비즈니스 역할, 데이터 접근을 합니다.

### 뷰
사용자 인터페이스를 담당합니다.

### 뷰모델
뷰와 모델 사이의 에이전트 역할을 합니다.

### BusinessLogic Architecture - Clean Architecture

<img src="https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg" alt="img" style="zoom:33%;" />

클린 아키텍쳐는 3개의 레이어로 구성됩니다. 프레젠테이션, 도메인, 데이터 레이어인데 이들 레이어는 안으로만 의존성을 향합니다.
프레젠테이션 레이어는 이 앱에서 뷰모델에 해당됩니다. UseCase를 사용해 데이터에 따라 화면을 조작하기 때문에 Usecase가 있는 도메인 레이어에 의존합니다.
도메인 레이어는 비즈니스 로직을 처리합니다. 도메인 레이어는 Usecase와 Entity를 가지고 있습니다.
데이터 레이어는 도메인에 필요한 모든 데이터를 조작하기 위한 레이어입니다. Repository와 DataSource를 가지고 있습니다.
도메인 레이어는 어플리케이션의 비즈니스 로직을 담고 있으므로 다른 레이어와 의존성을 가지고 있지 않습니다.

### DI - Koin

![image-20200401152705784](/Users/macbook/Library/Application Support/typora-user-images/image-20200401152705784.png)

의존성 주입 라이브러리로 Koin을 사용했습니다. 코틀린을 위한 DI 라이브러리로 순수 코틀린만으로 작성되었으며 어노테이션 프로세싱 및 리플렉션을 사용하지 않기 때문에 상대적으로 더 가볍습니다.
코틀린을 사용하는 이 앱에서는 Koin이 적절합니다.

<!-- CONTRIBUTING -->
## Contributing

기본적으로 [GitFlow](https://danielkummer.github.io/git-flow-cheatsheet/index.ko_KR.html) 방식으로 프로젝트를 진행한다.

1. Fork the Project
2. Create your Feature Branch by dev branch (`git checkout -b feature/myFeature dev`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Git Flow Plugin
- [Intellij](https://plugins.jetbrains.com/plugin/7315-git-flow-integration)


<!-- LICENSE -->
## License

```
MIT License

Copyright (c) 2020 김성규 오준택 이오형 최창익 오성진 최민성

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```



<!-- CONTACT -->
## Contact

- 김성규 - dsgn.yapp@gmail.com
- 오준택 - becon.yapp@gmail.com
- 이오형 - segfault.yapp@gmail.com
- 최창익 - iki.yapp@gmail.com
- 오성진 - sj.oh.yapp@gmail.com
- 최민성 - rogers.yapp@gmail.com

Project Link: [project name](https://github.com/YAPP-16th/Team_Android_2_Backend)


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[issues-shield]: https://img.shields.io/github/issues/YAPP-16th/Team_Android_2_Client
[issues-url]: https://github.com/YAPP-16th/Team_Android_2_Client/issues
[pulls-shield]: https://img.shields.io/github/issues-pr/YAPP-16th/Team_Android_2_Client
[pulls-url]: https://github.com/YAPP-16th/Team_Android_2_Client/pulls
[license-shield]: https://img.shields.io/github/license/YAPP-16th/Team_Android_2_Client
[license-url]: https://github.com/YAPP-16th/Team_Android_2_Backend/blob/master/LICENSE.txt
