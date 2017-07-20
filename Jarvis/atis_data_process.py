
def file_transfer(f_write, f_read):
    counter = 1
    left_sentence = ""
    right_sentence = ""
    for line in f_read:
        counter += 1
        print(counter)
        if (line == "\n"):
            f_write.write(left_sentence + right_sentence)
            f_write.write("\n")
            left_sentence = ""
            right_sentence = ""
        else:
            word_line = line.split()
            left_sentence += (word_line[0] + " ")
            right_sentence += (word_line[1] + " ")


f_write = open('atis_intent_dev.txt', 'w')
f_read = open('atis_data/atis_intent_dev.txt', 'r')

file_transfer(f_write, f_read)

f_write.close()
f_read.close()

f_write = open('atis_intent_test.txt', 'w')
f_read = open('atis_data/atis_intent_test.txt', 'r')

file_transfer(f_write, f_read)

f_write.close()
f_read.close()

