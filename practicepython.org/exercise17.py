#!/usr/bin/env python3

import requests
from bs4 import BeautifulSoup

def getPage(url):
    return requests.get(url).text

url = 'http://www.nytimes.com/'
html = getPage(url)
soup = BeautifulSoup(html, 'html.parser')

storyHeadingWrappers = soup.find_all(class_='story-heading')
for index, storyHeadingWrapper in enumerate(storyHeadingWrappers):
    for child in storyHeadingWrapper.findChildren('a', recursive = False):
        print('Heading ' + str(index) + ': ' + child.text.strip())
