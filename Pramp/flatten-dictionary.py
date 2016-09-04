"""
Given a dictionary, write a function to flatten it.
Consider the following input/output scenario for better understanding:

Input:
{
  'Key1': '1',
  'Key2': {
    'a' : '2',
    'b' : '3',
    'c' : {
      'd' : '3',
      'e' : '1'
    }
  }
}

Output:
{
  'Key1': '1',
  'Key2.a': '2',
  'Key2.b' : '3',
  'Key2.c.d' : '3',
  'Key2.c.e' : '1'
}
"""

import json


def flatten(sample, parent=None, flat={}):
    for key in sample.keys():
        if isinstance(sample[key], dict):
            if parent is None:
                flatten(sample[key], key, flat)
            else:
                flatten(sample[key], str(parent) + '.' + str(key), flat)
        else:
            if parent is None:
                flat[key] = sample[key]
            else:
                flat[str(parent) + '.' + str(key)] = sample[key]


sample = {
  'Key1': '1',
  'Key2': {
    'a': '2',
    'b': '3',
    'c': {
      'd': '3',
      'e': '1'
    }
  }
}
flat = {}

flatten(sample, None, flat)
print(json.dumps(flat, indent=4, sort_keys=True))
