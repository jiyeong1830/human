# opencsv, writecsv 함수를 생성하여 이용
import csv, os

# csv 파일을 이주 리스틀로 객체값을 반환하는 함수
def opencsv(filename):
    f = open('a.csv', 'r', encoding='utf-8') # 읽기 전용모드로 a.csv파일을 open
    reader = csv.reader(f)    # csv.reader로 csv파일내용을 읽어 new 변수
    output = []
    for i in reader:
        output.append(i)
    return output

# 이중리스트 객체를 csv 파일로 생성하는 함수
def writecsv(filename, the_list):
    with open(filename, 'w',newline = '', encoding='utf-8')as f: # 읽기 전용모드로 a.csv파일을 open
        csv_object = csv.writer(f, delimiter=',')
        csv_object.writerows(the_list)