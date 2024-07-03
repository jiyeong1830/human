import usecsv
import os

print(os.getcwd())
os.chdir(r'c:\Users\human-08\python-practice-1\240626')

a = [['국어', '영어', '수학'],[99,88,77]]
usecsv.writecsv('test.csv',a)