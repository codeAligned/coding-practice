#!/usr/bin/env python3

import requests
from bs4 import BeautifulSoup

url = 'http://www.vanityfair.com/style/society/2014/06/monica-lewinsky-humiliation-culture'
html = requests.get(url).text
soup = BeautifulSoup(html, 'html.parser')

article = ''
contentWrappers = soup.find_all(class_='content-section')

for content in contentWrappers:
    for ptag in content.findChildren('p'):
        article += str(ptag.text.strip().encode('utf-8')) + '\n'

    article += '\n\n'

with open('data/lewinsky-humiliation.txt', 'w') as fileobj:
    fileobj.write(article)
