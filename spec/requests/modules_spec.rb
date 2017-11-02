# frozen_string_literal: true

require 'spec_helper'

RSpec.describe '/v1/modules' do
  it_behaves_like 'POST', params: {}
  it_behaves_like 'GET all'
  it_behaves_like 'GET specific', key: 1
end
