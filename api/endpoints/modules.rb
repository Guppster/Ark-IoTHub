# frozen_string_literal: true
require 'ark'

module Api
  module Endpoints
    class Modules < Grape::API

      client = Ark::Client.new(
      :ip => '135.23.232.14',
      :port => 4001,
      :nethash => '6e84d08bd299ed97c212c886c98a57e36545c8f5d645ca7eeae63a8bd62d8988',
      :version => '1.0.1'
      )

      devices = []

      namespace :modules do
        desc 'create module'
        params do
          requires :json, type: JSON do
            requires :ip, type: String
          end
        end
        post do
          devices.insert(:ip)
          client.transactions
        end

        desc 'get all of modules',
             is_array: true
        get do
          # your code goes here
        end

        desc 'get specific module'
        params do
          requires :id
        end
        get ':id' do
          # your code goes here
        end
      end
    end
  end
end
