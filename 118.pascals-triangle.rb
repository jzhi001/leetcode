# frozen_string_literal: true

#
# @lc app=leetcode id=118 lang=ruby
#
# [118] Pascal's Triangle
#
# @param {Integer} num_rows
# @return {Integer[][]}
def generate(n)
  if n == 0
    []
  elsif n == 1
    [[1]]
  elsif n == 2
    [[1], [1, 1]]
  else
    ret = [[1], [1, 1]]
    n -= 2
    while n.positive?
      ret << row(ret[-1])
      n -= 1
    end
    ret
end
end

def row(arr)
  i = 0
  ret = [1]
  while i < arr.size - 1
    ret << arr[i] + arr[i + 1]
    i += 1
  end
  ret << 1
  ret
end
