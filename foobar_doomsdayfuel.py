from fractions import Fraction
from numpy.linalg import inv
import numpy as np

def gcd(x, y):
    def gcd1(x, y):
        if y == 0:
            return x
        return gcd1(y, x%y)
    return gcd1(abs(x), abs(y))

def simplify(x, y):
    g = gcd(x, y)
    return Fraction(int(x/g), int(y/g))

def lcm(x, y):
    return int(x*y/gcd(x,y))

def transform(mat):
    sum_list = list(map(sum, mat))
    bool_indices = list(map(lambda x: x == 0, sum_list))
    indices = set([i for i, x in enumerate(bool_indices) if x])
    new_mat = []
    for i in range(len(mat)):
        new_mat.append(list(map(lambda x: Fraction(0, 1) if(sum_list[i] == 0) else simplify(x, sum_list[i]), mat[i])))
    transform_mat = []
    zeros_mat = []
    for i in range(len(new_mat)):
        if i not in indices:
            transform_mat.append(new_mat[i])
        else:
            zeros_mat.append(new_mat[i])
    transform_mat.extend(zeros_mat)
    tmat = []
    for i in range(len(transform_mat)):
        tmat.append([])
        extend_mat = []
        for j in range(len(transform_mat)):
            if j not in indices:
                tmat[i].append(transform_mat[i][j])
            else:
                extend_mat.append(transform_mat[i][j])
        tmat[i].extend(extend_mat)
    return [tmat, len(zeros_mat)]

def transpose(mat):
    tmat = []
    for i in range(len(mat)):
        for j in range(len(mat)):
            if i == 0:
                tmat.append([])
            tmat[j].append(mat[i][j])
    return tmat


def mat_mult(mat1, mat2):
    res = []
    for i in range(len(mat1)):
        res.append([])
        for j in range(len(mat2[0])):
            res[i].append(Fraction(0, 1))
            for k in range(len(mat1[0])):
                res[i][j] += mat1[i][k] * mat2[k][j]
    return res

def splitQR(mat, lengthR):
    lengthQ = len(mat) - lengthR
    Q = []
    R = []
    for i in range(lengthQ):
        Q.append([int(i==j)-mat[i][j] for j in range(lengthQ)])
        R.append(mat[i][lengthQ:])
    return [Q, R]

def answer(mat):
    res = transform(mat)
    if res[1] == len(mat):
        return [1, 1]
    Q, R = splitQR(*res)
    Q = np.array(Q)
    i = inv(Q)
    res = mat_mult(i, R)
    row = res[0]
    l = 1
    for item in row:
        l = lcm(l, item.denominator)
    res = list(map(lambda x: long(x.numerator*l/x.denominator), row))
    res.append(l)
    return res
print(answer([[0, 1, 0, 0, 0, 1], [4, 0, 0, 3, 2, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]))