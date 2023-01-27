import matplotlib.pyplot as plt


# for arch in ['block', 'no_block' 'async']:
#     for metric in ['_sort', 'server', 'client']:
#         file1 = open(arch + metric, 'r')
#         lines = file1.readlines()
#         legend = lines[0]
#         params = line[1].split(" ")
#         x1 = range(params[3], params[4], params[5])
#         y1 = lines[2:]


for arch in ['block']:
    for metric in ['_sort', '_server', '_client']:
        file1 = open(arch + metric, 'r')
        lines = file1.readlines()
        legend = lines[0]
        params = lines[1].split(" ")
        x1 = range(int(params[3]), int(params[4]), int(params[5]))
        y1 = lines[2:]
        plt.plot(x1, y1, label = params[2])
        plt.title('Metric is ' + metric)
        plt.ylabel('time in ms')
        plt.xlabel('number of ' +  params[2])
        plt.legend()
        plt.savefig(arch + metric + ".jpg")
        plt.clf()
