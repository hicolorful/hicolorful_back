# 2022 HACK FESTA 컬러풀 팀 백엔드 서버
## 서비스 구조도
![image](https://github.com/hicolorful/hicolorful_back/assets/62099953/a503ebaa-a111-479c-86a6-ad21ba7e0727)

## 실행 방법
```
gradle bootRun
```
- base url: 13.125.166.49:8080

## 사용 방법
### 원재료 가격 예측 정보 불러오기
```
GET  {{base_url}}/fram-price?category={{category_name}}
```
### 상품 종류별 상품 특성 불러오기
```
GET  {{base_url}}/character?category={{category_name}}
```
### 가격별 선호도 불러오기
```
GET  {{base_url}}/preference?category={{category_name}}
```
### 상품별 플랫폼 가격 비교 불러오기
```
GET  {{base_url}}/compare/:product_id
```
### 상품 종류별 적정가 불러오기
```
GET  {{base_url}}/reasonable-price?category={{category_name}}
```
## API 명세서
https://documenter.getpostman.com/view/13577383/VUqpuxtY
