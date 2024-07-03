# 사전 작업: friends101.txt 파일을 현재 friends.py파일의 같은 폴더에 넣기
import os, re

print(os.getcwd())
# 여러분의 friends.py저장경로
os.chdir(r'c:\Users\human-08\python-practice-1\240625')

f = open('friends101.txt', 'r', encoding= 'utf-8') 
# friends101 대본 파일 내용 읽기모드로 열기
script101 = f.read()
print(script101[:100]) 
#  friends101 대본 파일 내용 중 앞에서부터 100개의 문자 가져오기

# 첫번째 실습 : 특정 인물의 대사만 모우기(Monica의 대사만 가져오기)
Line = re.findall(r'Monica:+', script101)
# type(Line) -> 리스트
for item in Line[:3]:
    print(item)

# Monicadml 대사만 있는  moica.txt 파일 만들기
f = open('monica.txt', 'w', encoding= 'utf-8')
monicaLineScript = ''
for monicaLineScript in Line:
    monicaLineScript += monicaLineScript + "\n"

f.write(monicaLineScript)
f.close()

# 두번째 실습: 등장인믈 리스트 만들기
# 등장인물 이름 모으기
# print(re.findall(r'[A-Z][a-z]+: ', script101))
# print('-' * 150)
# print(set(re.findall(r'[A-Z][a-z]+: ', script101)))

# 콜론과 빈공백 제거하기
listPeopleName = list(set(re.findall(r'[A-Z][a-z]+: ', script101)))
character = []
for PeopleName in listPeopleName:
    character.append(PeopleName[:-2])  
    # 뒤에서부터 2문자 제거하고 character 리스트에 넣기
    #print(peapleName[:-2])
print(character)

# 세번째 실습: 지문만 출력하기
# 지문만 가져오는 정규표현식 -> () 사이의 문자들
print(len(re.findall(r'\([A-Za-z].+?[a-z|\.]\)', script101)))  # 97개의 지문이 있음

# 네번째 실습:특정딘어의 예문만 모아 파일로 저장
# 특정 단어는 'would', 'take'
f = open('freinds101.txt', 'r', encoding= 'uft-8') # friends101
sentences = f.readlines()

# 20개만 출력해서 매칭이 되는지 테스트하기
for sente in sentences[:20]:
    if re.match(r'[A-Z][a-z]+:', sente):
        print(sente[:-1])

f.close()

would_sente = ''
for sente in sentences:
    if re.match(r'[A-Z][a-z]+:', sente) and re.search('would', sente):
        would_sente += sente + '\n'
f = open('would.txt', 'w', encoding= 'utf-8')
f.write(would_sente)

f.close()

take_sente = []
for sente in sentences:
    if re.match(r'[A-Z][a-z]+:', sente) and re.search('take', sente):
        take_sente += sente + '\n'
f = open('would.txt', 'w', encoding= 'utf-8')
f.write(take_sente)

f.close()

