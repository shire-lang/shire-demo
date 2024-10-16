import re

def validate_mainland_id(id_number):
    """校验中国大陆居民身份证号码"""
    if len(id_number) != 18:
        return False

    # 前17位应该都是数字，最后一位可能是X
    if not re.match(r"\d{17}[\dXx]", id_number):
        return False

    weights = (7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2)
    validate_codes = "10X98765432"

    sum_total = sum(int(num) * weight for num, weight in zip(id_number[:-1], weights))
    mod_result = sum_total % 11
    expected_code = validate_codes[mod_result]

    return id_number[-1].upper() == expected_code

def validate_hongkong_id(id_number):
    """校验香港居民身份证号码"""
    id_number = id_number.replace("(", "").replace(")", "")
    print(id_number)
    if not re.match(r"^[A-Z]{1,2}\d{6}[A0-9]$", id_number):
        return False

    id_characters = list(id_number)
    if len(id_characters) == 8:
        id_characters.insert(0, ' ')  # 补全为9位

    # 将字母转换为数字
    lookup = {' ': 36}
    for char in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
        lookup[char] = ord(char) - 55

    total = 0
    for i, char in enumerate(id_characters[:8]):
        if char.isdigit():
            value = int(char)
        else:
            value = lookup[char.upper()]
        total += value * (9 - i)

    remainder = total % 11
    check_digit = 'A' if remainder == 0 else str(11 - remainder) if remainder != 1 else '0'

    return id_characters[-1] == check_digit

def validate_macau_id(id_number):
    """校验澳门居民身份证号码"""
    if not re.match(r"^[1|5|7]\d{6}$$\d$$$", id_number):
        return False
    return True  # 澳门身份证暂无公开的校验算法

def validate_taiwan_id(id_number):
    """校验台湾居民身份证号码"""
    if not re.match(r"^[A-Z][12]\d{8}$", id_number):
        return False

    letters = {'A':10,'B':11,'C':12,'D':13,'E':14,'F':15,'G':16,'H':17,'J':18,'K':19,
               'L':20,'M':21,'N':22,'P':23,'Q':24,'R':25,'S':26,'T':27,'U':28,'V':29,
               'X':30,'Y':31,'W':32,'Z':33,'I':34,'O':35}

    first_char = id_number[0].upper()
    if first_char not in letters:
        return False

    nums = [int(d) for d in id_number[1:]]

    code = letters[first_char]
    nums = [code // 10] + [code %10] + nums

    weights = [1,9,8,7,6,5,4,3,2,1]
    total = sum(num * weight for num, weight in zip(nums, weights))

    return total % 10 == 0

def validate_id(id_number):
    """综合校验函数"""
    if validate_mainland_id(id_number):
        return "有效的中国大陆身份证号码"
    elif validate_hongkong_id(id_number):
        return "有效的香港身份证号码"
    elif validate_macau_id(id_number):
        return "有效的澳门身份证号码"
    elif validate_taiwan_id(id_number):
        return "有效的台湾身份证号码"
    else:
        return "无效的身份证号码"

# 测试
if __name__ == "__main__":
    test_ids = [
        "11010519491231002X",  # 大陆身份证
        "Z123456(A)",         # 香港身份证
        "71234567(8)",        # 澳门身份证
        "A123456789",         # 台湾身份证
    ]

    for tid in test_ids:
        result = validate_id(tid)
        print(f"身份证号 {tid} 校验结果: {result}")
