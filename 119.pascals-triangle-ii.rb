# frozen_string_literal: true

#
# @lc app=leetcode id=119 lang=ruby
#
# [119] Pascal's Triangle II
#
# @param {Integer} row_index
# @return {Integer[]}
def get_row(idx)
  if idx.negative?
    []
  elsif idx.zero?
    [1]
  elsif idx == 1
    [1, 1]
  else
    ret = [1, 1]
    idx -= 2
    while idx >= 0
      ret = row(ret)
      idx -= 1
    end
    ret
  end
end

def row(arr)
  ret = [1]
  i = 0
  while i < arr.size - 1
    ret << arr[i] + arr[i + 1]
    i += 1
  end
  ret << 1
  ret
end
