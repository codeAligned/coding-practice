rows = 12
cols = 12

table = []
for i in range(rows):
    tab = []
    for j in range(cols):
        tab.append((j + 1) * (i + 1))

    table.append(tab)

for tab in table:
    for i in tab:
        print(i, end = ' ')
    print()
