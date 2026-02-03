arr=[]
def sort(graph):
    for ar in graph:
        if graph[ar] ==[]:
            arr.append(ar)
            removw(graph,ar)
            return
def removw(graph, g_ele):
    a= g_ele
    graph.pop(a)
    for i in graph.values():
        if a in i:
            i.remove(a)
graph={ 'A':['E'],'B':['A','E'],'C':['A','E'],'D':['B','C','E'],'E':[]}
for i in range(len(graph)):
    sort(graph)
print(arr)
