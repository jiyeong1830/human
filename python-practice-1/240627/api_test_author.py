import requests     # api호출 패키지
from bs4 import BeautifulSoup  # json 혹은 xml을 paring하는 패키지

api_key = 'AHN3XXlLFnjzLiVo1YU7gsuOJIWfZhUstVzqVWoBRl8%2FsX6YJ8WS5R0ekuQ7k8bSWgHTEBsQ%3D%3D'
base_request_url = f'http://apis.data.go.kr/9720000/searchservice/basic?serviceKey={api_key}&pageno=1&displaylines=10&search=자료명,미국'

response = requests.get(base_request_url)
soup = BeautifulSoup(response.text, 'lxml')

print(soup.prettify)
